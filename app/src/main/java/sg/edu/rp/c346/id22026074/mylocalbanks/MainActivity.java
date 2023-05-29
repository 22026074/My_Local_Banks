package sg.edu.rp.c346.id22026074.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;
    String selectedBank = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDBS = findViewById(R.id.textViewBank);
        tvOCBC = findViewById(R.id.textViewBank2);
        tvUOB = findViewById(R.id.textViewBank3);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
            return true;
        } else if (id == R.id.chineseSelection) {
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact");

        if (v == tvDBS) {
            selectedBank = "DBS";
        } else if (v == tvOCBC) {
            selectedBank = "OCBC";
        } else if (v == tvUOB) {
            selectedBank = "UOB";
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == 0) {
            if (selectedBank == "DBS") {
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intentWeb);
            }
            else if (selectedBank == "OCBC") {
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intentWeb);
            }
            else if (selectedBank == "UOB") {
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intentWeb);
            }
            return true;
        } else if (item.getItemId() == 1) {
            if (selectedBank == "DBS") {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+1800+111+1111));
                startActivity(intentCall);
            }
            else if (selectedBank == "OCBC") {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+1800+363+3333));
                startActivity(intentCall);
            }
            else if (selectedBank == "UOB") {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+1800+222+2121));
                startActivity(intentCall);
            }
            return true;
        }
        return super.onContextItemSelected(item);
    }
}