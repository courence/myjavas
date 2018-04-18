package practice.jvm.gc;

/**
 * 内存分配回收策略
 * @author jiangc4
 * 
 */
public class MemaryAllocation {
	private static int _1MB = 1024*1024;
	public static void main(String[] args) {
		testTenuringThreshold();

	}
	
	/**
	 * 对象优先在Eden分配
	 * vm args: -verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC 
	 */
	public static void testAllocation(){
		byte[] allocation1,allocation2,allocation3,allocation4;
		allocation1 = new byte[2*_1MB];
		allocation2 = new byte[2*_1MB];
		allocation3 = new byte[2*_1MB];
		allocation4 = new byte[4*_1MB];//gc
	}
	
	/**
	 * 大数据直接分配在老年代 <br>
	 * vm args: -verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC 
	 * -XX:PretenureSizeThreshold=3145728 <br>
	 * 
	 *  -XX:PretenureSizeThreshold 参数只对Serial和ParNew有效
	 *  Parallel Scavenge不认识，一般不需要设置
	 *  当必须用此参数时可以考虑ParNew + CMS 组合
	 */
	public static void testPretenureSizeThreshold() {
		byte[] allocation = new byte[4*_1MB];
	}
	
	
	/**
	 * 长期存活的对象进入老年代 默认15<br>
	 *  vm args: -verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC 
	 * -XX:MaxTenuringThreshold=1 <br>
	 * 
	 * ###：当Survivor空间中相同年龄所有对象的大小的总和大于Survivor空间的一班时
	 * 年龄大于或等于该年龄的对象可以直接进入老年代，不用等到 MaxTenuringThreshold要求
	 * 
	 */
	public static void testTenuringThreshold(){
		byte[] allocation1,allocation2,allocation3;
		allocation1 = new byte[_1MB/8];
//		###：当Survivor空间中相同年龄所有对象的大小的总和大于Survivor空间的一班时
//		 * 年龄大于或等于该年龄的对象可以直接进入老年代，不用等到 MaxTenuringThreshold要求
//		allocation1 = new byte[_1MB/4];
		allocation2 = new byte[_1MB*4];
		allocation3 = new byte[_1MB*4];
		allocation3 = null;
		allocation3 = new byte[_1MB*4];
	}

}
