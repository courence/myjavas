package test.spring.springinaction.common.springidol;

public class Stage {
	private Stage(){}
	private static class StageSingletonHlder{
		static Stage instance =new Stage();
	}
	public static Stage getInstance(){
		return StageSingletonHlder.instance;
	}
}
