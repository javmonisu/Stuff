@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hole);
        Bundle extras = getIntent().getExtras();
        int players = extras.getInt("players");
        int holes = extras.getInt("holes");
        

    }