package com.homathon.homecamp.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.homathon.homecamp.MainActivity;
import com.homathon.homecamp.Model.MemberData;
import com.homathon.homecamp.Model.ScheduleData;
import com.homathon.homecamp.R;
import com.homathon.homecamp.adapter.MessageAdapter;
import com.homathon.homecamp.adapter.ScheduleAdapter;
import com.scaledrone.lib.Listener;
import com.scaledrone.lib.Message;
import com.scaledrone.lib.Room;
import com.scaledrone.lib.RoomListener;
import com.scaledrone.lib.Scaledrone;

import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


public class RealTimeVideoFragment extends AppCompatActivity implements RoomListener {

    private String channelID = "jZz2by9qw91QhD8i";
    private String roomName = "observable-room";
    private EditText editText;
    private Scaledrone scaledrone;
    private MessageAdapter messageAdapter;
    private ListView messagesView;
    private ImageButton sendTextButton;

    public static RealTimeVideoFragment newInstance() {
        RealTimeVideoFragment fragment = new RealTimeVideoFragment();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live);

        editText = (EditText) findViewById(R.id.editText);
        sendTextButton = findViewById(R.id.SendTextButton);



        messageAdapter = new MessageAdapter(this);
        messagesView = (ListView) findViewById(R.id.messages_view);
        messagesView.setAdapter(messageAdapter);

        messageAdapter.add(new com.homathon.homecamp.Model.Message("hello teacher",new MemberData("Hannaa", "blue"),false));
        messageAdapter.add(new com.homathon.homecamp.Model.Message("hello everyone !!",new MemberData("Suha", "red"),false));
        MemberData data = new MemberData(getRandomName(), getRandomColor());

        scaledrone = new Scaledrone(channelID, data);
        scaledrone.connect(new Listener() {
            @Override
            public void onOpen() {
                System.out.println("Scaledrone connection open");
                scaledrone.subscribe(roomName, RealTimeVideoFragment.this);
            }

            @Override
            public void onOpenFailure(Exception ex) {
                System.err.println(ex);
            }

            @Override
            public void onFailure(Exception ex) {
                System.err.println(ex);
            }

            @Override
            public void onClosed(String reason) {
                System.err.println(reason);
            }
        });
        sendTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String message = editText.getText().toString();
                if (message.length() > 0) {
                    scaledrone.publish("observable-room", message);
                    Toast.makeText(RealTimeVideoFragment.this,"sent",Toast.LENGTH_LONG).show();
                    editText.getText().clear();
                }
            }
        });

    }


    public void sendMessage(View view) {

    }
    @Override
    public void onOpen(Room room) {

    }

    @Override
    public void onOpenFailure(Room room, Exception ex) {

    }

    @Override
    public void onMessage(Room room, com.scaledrone.lib.Message receivedMessage) {
        final ObjectMapper mapper = new ObjectMapper();
        try {
            final MemberData data = mapper.treeToValue(receivedMessage.getMember().getClientData(), MemberData.class);
            boolean belongsToCurrentUser = receivedMessage.getClientID().equals(scaledrone.getClientID());
            final com.homathon.homecamp.Model.Message message = new com.homathon.homecamp.Model.Message(receivedMessage.getData().asText(), data, belongsToCurrentUser);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    messageAdapter.add(message);
                    messagesView.setSelection(messagesView.getCount() - 1);
                }
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

        private String getRandomName() {
            String[] adjs = {"autumn", "hidden", "bitter", "misty", "silent", "empty", "dry", "dark", "summer", "icy", "delicate", "quiet", "white", "cool", "spring", "winter", "patient", "twilight", "dawn", "crimson", "wispy", "weathered", "blue", "billowing", "broken", "cold", "damp", "falling", "frosty", "green", "long", "late", "lingering", "bold", "little", "morning", "muddy", "old", "red", "rough", "still", "small", "sparkling", "throbbing", "shy", "wandering", "withered", "wild", "black", "young", "holy", "solitary", "fragrant", "aged", "snowy", "proud", "floral", "restless", "divine", "polished", "ancient", "purple", "lively", "nameless"};
            String[] nouns = {"waterfall", "river", "breeze", "moon", "rain", "wind", "sea", "morning", "snow", "lake", "sunset", "pine", "shadow", "leaf", "dawn", "glitter", "forest", "hill", "cloud", "meadow", "sun", "glade", "bird", "brook", "butterfly", "bush", "dew", "dust", "field", "fire", "flower", "firefly", "feather", "grass", "haze", "mountain", "night", "pond", "darkness", "snowflake", "silence", "sound", "sky", "shape", "surf", "thunder", "violet", "water", "wildflower", "wave", "water", "resonance", "sun", "wood", "dream", "cherry", "tree", "fog", "frost", "voice", "paper", "frog", "smoke", "star"};
            return (
                    adjs[(int) Math.floor(Math.random() * adjs.length)] +
                            "_" +
                            nouns[(int) Math.floor(Math.random() * nouns.length)]
            );
        }

        private String getRandomColor() {
            Random r = new Random();
            StringBuffer sb = new StringBuffer("#");
            while(sb.length() < 7){
                sb.append(Integer.toHexString(r.nextInt()));
            }
            return sb.toString().substring(0, 7);
        }
}
