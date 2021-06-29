package org.zerock.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Test1VO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class Test1Tests {

	/*
	상세한 풀이는 BoardMapperTests 에서 확인 
	Test1Tests 는 간단한 코드
	
	*/
	
	private Test1Mapper mapper;

	@Autowired
	public void setMapper(Test1Mapper mapper) {
		this.mapper = mapper;
	}
	
	@Test
	public void testMapper() {
		assertNotNull(mapper); // 객체 mapper가 null값이 아닌지 확인
	}
	
	@Test
	public void testGetList() {
		List<Test1VO> list = mapper.getList();
		
		assertTrue(list.size() > 0); // assertTrue(x) : x가 true 인지 확인
	}
	

	@Test
	public void testInsert() {
		Test1VO test = new Test1VO();
		test.setName("newbie");
		test.setAge(99);

		int cnt = mapper.insert(test);

		assertEquals(1, cnt);
	}
	
	@Test
	public void testInsertSelectKey() {
		Test1VO test = new Test1VO();
		test.setName("newbie");
		test.setAge(99);
		
		mapper.insertSelectKey(test);
		
		assertNotEquals(0, test.getId());
	}
	
	@Test
	public void testRead() {
		Test1VO vo = mapper.read(2);

		assertEquals("Nana", vo.getName());
		assertEquals(20, vo.getAge());


	}
	

	@Test
	public void testDelete() {
		mapper.delete(20);

		Test1VO vo = mapper.read(20);

		assertNull(vo);
	}
	
	@Test
	public void testUpdate() {
		Test1VO test = new Test1VO();
		test.setId(1);
		test.setName("newbie");
		test.setAge(100);

		mapper.update(test);
		
		Test1VO test1 = mapper.read(1);
		assertEquals("newbie", test1.getName());
		assertEquals(100, test1.getAge());
	
	}
	
}







