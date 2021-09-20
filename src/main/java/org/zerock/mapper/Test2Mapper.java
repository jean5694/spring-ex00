package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface Test2Mapper {

//	public int sql1(@Param("type") String type);
//	쿼리에서 #{abc} 형태는 bean.getAbc() 의미로 받아들여짐 -> bean 객체는 매퍼의 파라미터 값을 bean 객체로써 받아 씀	
//	ex) #{type} 형태는 type.getType을 의미함
//	이렇게 파라미터 값 자체를 그대로 사용하기 위해선
//	@Param("type")으로 이름을 따로 지정해준 뒤 사용할 것 (*이름은 xml 쿼리에서 사용한 명칭과 동일하게)

	
	public int sql1(@Param("t") String type);

	public int sql2(@Param("type") String t);
	
	public int sql3(@Param("type") String t);
	
	public int sql4(@Param("type") String t);
	
	public int sql5(@Param("type") String t);
	 
	public int sql6(@Param("list") List<String> types);
//	여러개의 string이 담겨있는 types라는 리스트를 list라는 이름으로 지정하여 사용함
	
	public int sql7(@Param("list") List<String> types);
}
 