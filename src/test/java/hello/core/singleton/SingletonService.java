package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();
    //자기 자신을 하나 가지고 있기.. class 레벨에 올라가므로, 1개만 가지게 된다.
    //static : 1개만 사용하겠다, 공유하겠다. static 메모리에 올라감
    //final : 재할당하지 못하게 하는 것. 하지만 값이 변할 수 있다.
    //private static final : 선언한 변수를 사용하면 재할당하지 못하며, 메모리에 한 번 올라가면 같은 값을 클래스 내부의 전체 필드, 메서드에서 공유한다.

    public static SingletonService getInstance(){
        return instance; //조회
    }

    private SingletonService(){ //private 생성자이므로 다른 곳에서 생성하지 못함.
    }

    public void logic(){
        System.out.println("싱글톤 호출");
    }
}

//오직 getInstance() 메서드를 통해서만 조회할 수 있다.