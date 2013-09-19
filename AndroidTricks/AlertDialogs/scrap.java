 public void errorAlert(){
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Bad values entered");
        alertDialog.setMessage("Please enter values greater than one");
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(PlayActivity.this,PlayActivity.class));
            }
        });
        alertDialog.show();
    }