 Intent intent = new Intent(PlayActivity.this, HoleActivity.class);
 intent.putExtra("players", numberOfPlayers);
 intent.putExtra("holes", numberOfHoles);
 startActivity(intent);