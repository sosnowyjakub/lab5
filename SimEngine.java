package lab3;

public class SimEngine {
	private double masa;
	private double wspTl;
	private double wspSp;
	private double lSwobodna; 
	private Vector2D pMasy; 
	private Vector2D vMasy; 
	private Vector2D pPunktuZawieszenia;
	private double g;
	
	public double getmasa(){ // akcesor (inaczej getter)
	return masa;
	}
	public void setmasa(double masa){
	this.masa=masa;
	}
	public double getwspTl(){ // akcesor (inaczej getter)
	return wspTl;
	}
	public void setwspTl(double wspTl){
	this.wspTl=wspTl;
	}
	public double getwspSp(){ // akcesor (inaczej getter)
	return wspSp;
	}
	public void setwspSp(double wspSp){
	this.wspSp=wspSp;
	}
	public double getlSwobodna(){ // akcesor (inaczej getter)
	return lSwobodna;
	}
	public void setlSwobodna(double lSwobodna){
	this.lSwobodna=lSwobodna;
	}
	public Vector2D getpMasy(){ // akcesor (inaczej getter)
	return pMasy;
	} 
	public void setpMasy(Vector2D pMasy){
	this.pMasy=pMasy;
	}
	public Vector2D getvMasy(){ // akcesor (inaczej getter)
	return vMasy;
	} public void setvMasy(Vector2D vMasy){
	this.vMasy=vMasy;
	}
	public Vector2D getpPunktuZawieszenia(){ // akcesor (inaczej getter)
		return pPunktuZawieszenia;
		} public void setpPunktuZawieszenia(Vector2D pPunktuZawieszenia){
		this.pPunktuZawieszenia=pPunktuZawieszenia;
		}
		public double getG(){
		return g;
		}
		public void setG(double g){
		this.g=g;
		}
		public SimEngine (double masa,double wspTl,double wspSp,double lSwobodna,Vector2D pMasy,Vector2D vMasy,Vector2D pPunktuZawieszenia,double g) {
		this.masa=masa;
		this.wspSp=wspSp;
		this.wspTl=wspTl;
		this.lSwobodna=lSwobodna;
		this.pMasy=pMasy;
		this.vMasy=vMasy;
		this.pPunktuZawieszenia=pPunktuZawieszenia;
		this.g=g;
		}
		public void symulacjaUkladu (double symulacja){
			//tworzymy obiekty klasy Vecotr2D dla poszczególnych si³. Wykorzystujemy klase Vector2D w obliczeniach
			Vector2D FWyp=new Vector2D(); //Si³a wypadkowa 
			Vector2D FSpr=new Vector2D(); //Sila Sprezystosci 
			Vector2D FGraw=new Vector2D(0,masa*g); //Sila Grawitacji 
			Vector2D Fb=new Vector2D(); //Tlumienie
			FSpr=pPunktuZawieszenia.normalizacja().mnozenie(wspSp*(pMasy.minus(pPunktuZawieszenia).dlugosc()-lSwobodna)); //obliczamy si³e sprê¿yatoœci
			FWyp=FSpr.suma(Fb).suma(FGraw); //obliczamy si³ê wypadkow¹
			Fb=vMasy.mnozenie(-wspTl); //obliczamy t³umienie
			vMasy=vMasy.suma(FWyp.mnozenie(symulacja/masa)); //obliczamy prêdkosc
			pMasy=pMasy.suma(vMasy.mnozenie(symulacja/masa)); //oraz po³o¿enie masy
			}
			public void reset(){
			vMasy.x=0;
			vMasy.y=0;
			}}
		
