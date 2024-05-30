package com.laurence0.mybatis.dao;

import java.util.List;
import java.util.Map;

import com.laurence0.mybatis.pojo.MemberAddress;

public interface MemberAddressDao {
	public int save(MemberAddress memberAddress);
	public List<MemberAddress> findAll();
	public int updateReceiverById(Map map);
	public int deleteById(int address_id);
	public List<MemberAddress> dynamicIfTest(MemberAddress memberAddress);
	public List<MemberAddress> dynamicChooseTest(MemberAddress memberAddress);
	public List<MemberAddress> dynamicTrimTest(MemberAddress memberAddress);
	public List<MemberAddress> dynamicWhereTest(MemberAddress memberAddress);
	public int dynamicSetTest(MemberAddress memberAddress);
	public List<MemberAddress> dynamicForeachTest(List<Integer> ids);
	public List<MemberAddress> dynamicSelect(MemberAddress memberAddress);
	public List<MemberAddress> findUnion(int member_id);
}
