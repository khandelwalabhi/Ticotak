package com.abhi.ticotak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameActive = true;
    //player representation
    //0-X
    //1-O
    int activePlayer = 0;
    int[] gameState = {2 ,2 ,2 ,2 ,2 ,2 ,2 ,2 ,2};
    //state meanings:
    //0-X
    //1-O
    //2-Null
    int[][] winPositions ={ {0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6} };
    public void Playertap (View view)
    {
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if(!gameActive)
        {
            gameReset(view);
        }
        if(gameState[tappedImage]==2 )
        {
            gameState[tappedImage]=activePlayer;
            img.setTranslationY(-1000f);
            if(activePlayer==0)
            {
                img.setImageResource(R.drawable.x1);
                activePlayer=1;
                TextView status = findViewById(R.id.status);
                status.setText("O's Turn - Tap To Play");
            }
            else
            {
                img.setImageResource(R.drawable.o1);
                activePlayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("X's Turn - Tap To Play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        //check if any player has won
        for(int[] winPosition : winPositions)
        {
            if(gameState[winPosition[0]]==gameState[winPosition[1]]
                    &&gameState[winPosition[1]]==gameState[winPosition[2]] &&
                    gameState[winPosition[0]]!=2 )
            {
                String winnweStr;
                gameActive = false;
                if(gameState[winPosition[0]]==0)
                {
                    winnweStr = "X has won";
                }
                else
                {
                    winnweStr = "O has won";
                }
                //update the status bar for winner
                TextView status = findViewById(R.id.status);
                status.setText(winnweStr);
            }


        }
        boolean empty = false;
        for(int state : gameState)
        {
            if(state==2)
            {
                empty=true;
                break;
            }
        }
        if(!empty&&gameActive)
        {
            gameActive = false;
            String winstr;
            winstr="Nobody has won";
            TextView status = findViewById(R.id.status);
            status.setText(winstr);
        }


    }

    public void gameReset (View view)
    {
        gameActive=true;
        activePlayer=0;
        for(int i=0;i<gameState.length;i++)
        {
            gameState[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}