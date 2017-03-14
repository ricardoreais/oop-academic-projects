public class TCubeTest {

	@Test
	public void leftVertical(){
		
		String s1=("BGG00000");
		String s2=("YWWOYYWR");
		String s3=("YWWOYYWR");
		String s4=("YWWOYYWR");
		String s5=("GBB00000");
		String s=new String(s1+s2+s3+s4+s5);
		TCube inicial=new TCube(s);
		
		String o1=("GGG00000");
		String o2=("WWWOYYYR");
		String o3=("WWWOYYYR");
		String o4=("WWWOYYYR");
		String o5=("BBB00000");
		String o=new String(o1+o2+o3+o4+o5);
		TCube objective= new TCube(o);
		
		inicial.leftVertical();
		assertEquals(objective.getConfig(),inicial.getConfig());
		
	}

	@Test
	public void rightVertical(){
		
		String s1=("GGB00000");
		String s2=("WWYOWYYR");
		String s3=("WWYOWYYR");
		String s4=("WWYOWYYR");
		String s5=("BBG00000");
		String s=new String(s1+s2+s3+s4+s5);
		TCube inicial=new TCube(s);
		
		String o1=("GGG00000");
		String o2=("WWWOYYYR");
		String o3=("WWWOYYYR");
		String o4=("WWWOYYYR");
		String o5=("BBB00000");
		String o=new String(o1+o2+o3+o4+o5);
		TCube objective= new TCube(o);
		
		
		inicial.rightVertical();
		assertEquals(objective.getConfig(),inicial.getConfig());
	}
	 
	
	
	



@Test
	public void midVertical(){
		
		String s1=("GBG00000");
		String s2=("WYWOYWYR");
		String s3=("WYWOYWYR");
		String s4=("WYWOYWYR");
		String s5=("BGB00000");
		String s=new String(s1+s2+s3+s4+s5);
		TCube inicial=new TCube(s);
		
		String o1=("GGG00000");
		String o2=("WWWOYYYR");
		String o3=("WWWOYYYR");
		String o4=("WWWOYYYR");
		String o5=("BBB00000");
		String o=new String(o1+o2+o3+o4+o5);
		TCube objective= new TCube(o);
		
		
		inicial.midVertical();
		assertEquals(objective.getConfig(),inicial.getConfig());
		
	}
	
	
	@Test
	public void upHoziontal(){
		
		String s1=("GGG00000");
		String s2=("YYYRWWWO");
		String s3=("WWWOYYYR");
		String s4=("WWWOYYYR");
		String s5=("BBB00000");
		String s=new String(s1+s2+s3+s4+s5);
		TCube inicial=new TCube(s);
		
		String o1=("GGG00000");
		String o2=("WWWOYYYR");
		String o3=("WWWOYYYR");
		String o4=("WWWOYYYR");
		String o5=("BBB00000");
		String o=new String(o1+o2+o3+o4+o5);
		TCube objective= new TCube(o);
		
		
		inicial.upHorizontal();
		assertEquals(objective.getConfig(),inicial.getConfig());
		
		
	}
	
	
	
	




@Test
	public void midHoziontal(){
		
		String s1=("GGG00000");
		String s2=("WWWOYYYR");
		String s3=("YYYRWWWO");
		String s4=("WWWOYYYR");
		String s5=("BBB00000");
		String s=new String(s1+s2+s3+s4+s5);
		TCube inicial=new TCube(s);
		
		String o1=("GGG00000");
		String o2=("WWWOYYYR");
		String o3=("WWWOYYYR");
		String o4=("WWWOYYYR");
		String o5=("BBB00000");
		String o=new String(o1+o2+o3+o4+o5);
		TCube objective= new TCube(o);
		
		inicial.midHorizontal();
		assertEquals(objective.getConfig(),inicial.getConfig());
		
		
	}
	
	@Test
	public void downHoziontal(){
		
		String s1=("GGG00000");
		String s2=("WWWOYYYR");
		String s3=("WWWOYYYR");
		String s4=("YYYRWWWO");
		String s5=("BBB00000");
		String s=new String(s1+s2+s3+s4+s5);
		TCube inicial=new TCube(s);
		
		String o1=("GGG00000");
		String o2=("WWWOYYYR");
		String o3=("WWWOYYYR");
		String o4=("WWWOYYYR");
		String o5=("BBB00000");
		String o=new String(o1+o2+o3+o4+o5);
		TCube objective= new TCube(o);
		
		inicial.downHorizontal();
		assertEquals(objective.getConfig(),inicial.getConfig());
		
		
}

	







@Test
	public void twoMoves(){
		
		String s1=("BGG00000");
		String s2=("YYYRWWWR");
		String s3=("YWWOYYWR");
		String s4=("WWWOYYYO");
		String s5=("GBB00000");
		String s=new String(s1+s2+s3+s4+s5);
		TCube inicial=new TCube(s);
		
		
		String o1=("GGG00000");
		String o2=("WWWOYYYR");
		String o3=("WWWOYYYR");
		String o4=("WWWOYYYR");
		String o5=("BBB00000");
		String o=new String(o1+o2+o3+o4+o5);
		TCube objective= new TCube(o);
		
		inicial.leftVertical();
		inicial.upHorizontal();
		assertEquals(objective.getConfig(),inicial.getConfig());
		
	}
	
	
	@Test
	public void isSolvedTest(){
		
		ArrayList<String> objectives= new ArrayList<String>();
		objectives.add("GGG00000WWWOYYYRWWWOYYYRWWWOYYYRBBB00000");
		objectives.add("OOO00000WWWBYYYGWWWBYYYGWWWBYYYGRRR00000");
		objectives.add("BBB00000WWWRYYYOWWWRYYYOWWWRYYYOGGG00000");
		objectives.add("RRR00000WWWGYYYBWWWGYYYBWWWGYYYBOOO00000");
		objectives.add("GGG00000YYYRWWWOYYYRWWWOYYYRWWWOBBB00000");
		objectives.add("RRR00000YYYBWWWGYYYBWWWGYYYBWWWGOOO00000");
		objectives.add("BBB00000YYYOWWWRYYYOWWWRYYYOWWWRGGG00000");
		objectives.add("OOO00000YYYGWWWBYYYGWWWBYYYGWWWBRRR00000");
		
		
		String o1=("GGG00000");
		String o2=("WWWOYYYR");
		String o3=("WWWOYYYR");
		String o4=("WWWOYYYR");
		String o5=("BBB00000");
		String o=new String(o1+o2+o3+o4+o5);
		TCube objective= new TCube(o);
		
		for(String i:objectives){
			if(objective.getConfig().equals(i))
				assertEquals(objective.getConfig(),i);
		}
	}
	
	
	
	

@Test
	public void getSuccessors(){
		
		String o1=("GGG00000");
		String o2=("WWWOYYYR");
		String o3=("WWWOYYYR");
		String o4=("WWWOYYYR");
		String o5=("BBB00000");
		String o=new String(o1+o2+o3+o4+o5);
		TCube inicial= new TCube(o);
		
		inicial.leftVertical();
		
		ArrayList<TCube> alst=new ArrayList<TCube>();
		TCube a=new TCube(o,0);
		TCube b=new TCube(o,0);
		TCube c=new TCube(o,0);
		TCube d=new TCube(o,0);
		TCube e=new TCube(o,0);
		TCube f=new TCube(o,0);
		
		a.leftVertical();
		b.midVertical();
		c.rightVertical();
		d.upHorizontal();
		e.midHorizontal();
		f.downHorizontal();
		
		
		alst.add(a);
		alst.add(b);
		alst.add(c);
		alst.add(d);
		alst.add(e);
		alst.add(f);
	
		for(TCube i:alst){
			
			System.out.println(i);
			if(inicial.getConfig().equals(i.getConfig())){
				assertEquals(inicial.getConfig(),i.getConfig());
			}
				
		
		}
	}

}