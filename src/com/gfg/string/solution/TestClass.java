package com.gfg.string.solution;

class Add{

   protected int addNumbers(int a, int b){
	return a+b;
   }
}

class Test extends Add{
   public static void main(String []aa)
{
	Test obj = new Test();
	System.out.println(obj.addNumbers(11, 22));
   }
}