package aop.pointcut.plus;



class ServiceImpl extends ServiceAbstract implements ServiceInterface {
	
	@Override
	public void update(String string) {
		{
			System.out.println("**** test.mock");
		}
	}

}
