package packet;

import java.util.Random;

public class Hilo extends Thread{
long dados;
int cara,one=0,two=0,three=0,four=0,five=0,six=0,result=0;
public Hilo(long dados) {
	this.dados=dados;
}

@Override
public void run() {
	Random r = new Random();
	for(int i = 0 ; i < dados; i++){
		cara = r.nextInt(6)+1;
		switch(cara){
		case 1:
			one++;
			break;
		case 2:
			two++;
			break;
		case 3:
			three++;
			break;
		case 4:
			four++;
			break;
		case 5:
			five++;
			break;
		case 6:
			six++;
			break;
		}
		result+=cara;
	}
}

public int getOne() {
	return one;
}

public int getTwo() {
	return two;
}

public int getThree() {
	return three;
}


public int getFour() {
	return four;
}

public int getFive() {
	return five;
}

public int getSix() {
	return six;
}
public int getResult() {
	return result;
}

}
