package inter.exam2;

public class MyInterfaceExam {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}


abstract class Unit {

}


abstract class Building {

}


class SCV extends Unit implements Mechanic, Bionic {

}


class SiegeTank extends Unit implements Mechanic {

}


class Marine extends Unit implements Bionic, Dopable {

}


class CommandCenter extends Building implements Fixable {

}


interface Mechanic extends Fixable {

}


interface Bionic extends Curable {

}


interface Fixable {

}


interface Curable {

}


interface Dopable {

}
