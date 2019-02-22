package com.example.a96653.LetsCode;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class thirdlevel_8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdlevel_8);
        //NEXT BUTTON
        final MySQLliteHelper m=new MySQLliteHelper(this);
        ImageView goButton=(ImageView) findViewById(R.id.next_thirdlevel_8);

        goButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        openSecondActivity();
                        SharedPreferences prefs = getSharedPreferences("pref_thirdLevel_8", MODE_PRIVATE);
                        boolean firstStart = prefs.getBoolean("firstStart", true);
                        if (firstStart){
                            m.UpdateNumOfLesson(11,"Nepton");//MOST BE CHANGED TO THE WRITE ONES
                            SharedPreferences pref = getSharedPreferences("pref_thirdLevel_8", MODE_PRIVATE);
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putBoolean("firstStart", false);
                            editor.apply();}
                    }//end onClick

                }//end onClickListner

        );
        //scoreBox display
        TextView scoredisplay=(TextView) findViewById(R.id.scoreBox__thirdlevel_8);
        scoredisplay.setText(m.getChildScore()+"" );

        //HOME BUTTON
        ImageButton homebtn9=(ImageButton)findViewById(R.id.homebtn_thirdlevel_8);
        homebtn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gohome=new Intent (getApplicationContext(),MainActivity.class);
                startActivity(gohome);
            }
        });

        ImageView previous3=(ImageView)findViewById(R.id.previous_thirdlevel_8);
        previous3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoToprevious();
            }
        });

    }
    public void openSecondActivity() {

        Intent intent = new Intent(this, thirdlevel_8.class);//most be changed to thirdlevel_9
        startActivity(intent);

    }
    public void GoToprevious(){
        Intent goBack=new Intent(getApplicationContext(),thirdlevel_7.class);
        startActivity(goBack);
    }
}
