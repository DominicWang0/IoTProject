package com.laurence0.mybatis.test;

import java.sql.Timestamp;
import java.util.*;

import com.laurence0.mybatis.dao.MemberAddressDao;
import com.laurence0.mybatis.pojo.MemberAddress;
import com.laurence0.mybatis.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import org.junit.Test;

public class TestMemberAddressDao {
	//获取SqlSession
	SqlSession session= MybatisUtil.getSqlSession();
	//1.产生一个实现类 2.创建实现类的实例
	MemberAddressDao memberAddressDao=session.getMapper(MemberAddressDao.class);
	
	@Test
	public void testFindUnion(){
		List<MemberAddress> mas=memberAddressDao.findUnion(2);
		for(MemberAddress ma1:mas){
			System.out.println(ma1);
			System.out.println(ma1.getMember());
		}
		session.close();
	}
	@Test
	public void testDynamicSelect(){
		MemberAddress ma=new MemberAddress();
//		ma.setMember_id(2);
//		ma.setReceiver("李素素");
		ma.setMobile("13971986543");
		List<MemberAddress> mas=memberAddressDao.dynamicSelect(ma);
		for(MemberAddress ma1:mas){
			System.out.println(ma1);
		}
		session.close();
	}
	@Test
	public void testDynamicForeach(){
		List<Integer> ids=new ArrayList<Integer>();
		ids.add(2);
		ids.add(3);
		ids.add(4);
		System.out.println(ids);
		List<MemberAddress> mas=memberAddressDao.dynamicForeachTest(ids);
		for(MemberAddress ma1:mas){
			System.out.println(ma1);
		}
		session.close();
	}
	@Test
	public void testDynamicSet(){
		MemberAddress ma=new MemberAddress();
		ma.setMobile("13376543198");
		ma.setReceiver("李师师");
		ma.setAddress_id(3);
		int rows=memberAddressDao.dynamicSetTest(ma);
		System.out.println(rows);
		session.commit();
		session.close();
	}
	@Test
	public void testDynamicWhere(){
		MemberAddress ma=new MemberAddress();
		ma.setMember_id(3);
		ma.setProvice("广东省");
		ma.setReceiver("李素素");
		List<MemberAddress> mas=memberAddressDao.dynamicWhereTest(ma);
		for(MemberAddress ma1:mas){
			System.out.println(ma1);
		}
		session.close();
	}
	@Test
	public void testDynamicTrim(){
		MemberAddress ma=new MemberAddress();
		ma.setMember_id(3);
		ma.setProvice("广东省");
		ma.setReceiver("李素素");
		List<MemberAddress> mas=memberAddressDao.dynamicTrimTest(ma);
		for(MemberAddress ma1:mas){
			System.out.println(ma1);
		}
		session.close();
	}
	@Test
	public void testDynamicChoose(){
		MemberAddress ma=new MemberAddress();
//		ma.setProvice("广东省");
//		ma.setReceiver("李素素");
		ma.setMobile("13598763154");
		List<MemberAddress> mas=memberAddressDao.dynamicChooseTest(ma);
		for(MemberAddress ma1:mas){
			System.out.println(ma1);
		}
		session.close();
	}
	
	@Test
	public void testDynamicIf(){
		MemberAddress ma=new MemberAddress();
		ma.setProvice("广东省");
		ma.setReceiver("%李%");
		List<MemberAddress> mas=memberAddressDao.dynamicIfTest(ma);
		for(MemberAddress ma1:mas){
			System.out.println(ma1);
		}
		session.close();
	}
	@Test
	public void testSave(){
		MemberAddress memberAddress=new MemberAddress();
		memberAddress.setAddress_id(null);
		//为李四添加一个收货地址
		memberAddress.setMember_id(3);
		memberAddress.setProvice("湖北省");
		memberAddress.setCity("武汉市");
		memberAddress.setRegion("汉阳区");
		memberAddress.setAddr("汉阳");
		memberAddress.setMobile("13376315498");
		memberAddress.setReceiver("王舞舞");
		memberAddress.setCreatime(new Timestamp(System.currentTimeMillis()));
		memberAddress.setModifytime(new Timestamp(System.currentTimeMillis()));
		memberAddressDao.save(memberAddress);
		session.commit();
		session.close();
	}
	
	@Test
	public void testFindAll(){
		List<MemberAddress> addres=memberAddressDao.findAll();
		for(MemberAddress ma:addres){
			System.out.println(ma);
		}
		session.close();
	}
	
	@Test
	public void testUpdate1(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("receiver", "李诗诗");
		map.put("address_id", 1);
		memberAddressDao.updateReceiverById(map);
		session.commit();
		session.close();
	}
	
	@Test
	public void testDelete1(){
		memberAddressDao.deleteById(1);
		session.commit();
		session.close();
	}
}
