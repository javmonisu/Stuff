package com.javmonisu.createbuttondynamically;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
    public void moreButtons(View view){
        Button newButton = new Button(this);
        newButton.setText("New Button!");
        TableLayout tableLayout = (TableLayout)findViewById(R.id.tablelayout);
        TableRow tableRow = new TableRow(this);
        tableRow.addView(newButton);
        tableLayout.addView(tableRow);
    }
    public void lessButtons(View view){
        TableLayout tableLayout = (TableLayout)findViewById(R.id.tablelayout);
        int tableChildrenLength = tableLayout.getChildCount();
        if(tableChildrenLength>1){
            tableLayout.removeViewAt(tableLayout.getChildCount()-1);

        }else{
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Not enough buttons");
            alertDialog.setMessage("Please add more buttons before");
            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            alertDialog.show();
        }
    }
    
}
