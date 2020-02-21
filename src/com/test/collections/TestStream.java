/**
 * 
 */
package com.test.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

/**
 * @author dell
 *
 */
public class TestStream {
	
	
	public static class Relation{
		private Long aaaId;
		
		private Long bbbId;

		public Long getAaaId() {
			return aaaId;
		}

		public void setAaaId(Long aaaId) {
			this.aaaId = aaaId;
		}

		public Long getBbbId() {
			return bbbId;
		}

		public void setBbbId(Long bbbId) {
			this.bbbId = bbbId;
		}

		public Relation(Long aaaId, Long bbbId) {
			super();
			this.aaaId = aaaId;
			this.bbbId = bbbId;
		}
		
		public Relation(Long aaaId) {
			super();
			this.aaaId = aaaId;
		}
		
		public String toString(){
			return "AAA = "+this.aaaId+",BBB = "+this.bbbId;
		}
	}
	
    public static  List<Long> splitIdListByStr(String ids){
        String[] idArr = org.apache.commons.lang3.StringUtils.split(ids,",");
        Stream s = Stream.of(idArr);
        return Stream.of(idArr).map(id->Long.parseLong(id)).collect(Collectors.toList());
    }

	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list = Arrays.asList("sky","sky","sky","sky","sky");
		
		List<String> result = null;
		
        //1.È¥ÖØ
		// result = list.stream().distinct().collect(Collectors.toList());
		 
		 
		 //2.ÅÅÐò
		// result = list.stream().sorted().collect(Collectors.toList());
		 
		 //3.¹ýÂË
//		result = list.stream().filter(a->!"sky".equals(a)).collect(Collectors.toList());
//		 
//		 result.forEach(a->System.out.println(a));
//		 System.out.println(list.stream().anyMatch(a->!a.equals("sky")));
//		 
//		 List<Integer> lList = Arrays.asList(2,45,4234,354,33);
//		
//		 int sum = lList.stream().reduce(0,(x,y)->x+= y);
//		 int avg = lList.stream().reduce(0,(x,y)->x+= y)/lList.size();
//		 int sum1 = lList.stream().reduce(0, (x,y)-> x+= y+3);
//		 int sum2 = lList.stream().map(x->x+3).reduce(0,(x,y)->x+=y);
//		 Optional<Integer> opt = lList.stream().map(x->x+3).reduce(Integer::sum);
//		 int sum3 = opt.get();
//		 
//		 System.out.println(sum3);
		
//		List<Long> listLong = new ArrayList<>();
////		listLong.add(12L);
//		listLong.add(23L);
//		listLong.add(32L);
//		String ids = listLong.stream().map(idLong->String.valueOf(idLong).concat(",")).reduce("", String::concat);
//		System.out.println("@@@@@@@@@@@@@@"+ids);
//		
//		       String[] idArr = org.apache.commons.lang3.StringUtils.split(ids,",");
//		       System.out.println(idArr[0]);
//		       System.out.println(idArr[1]);
		
//		List<Relation> relations  = new ArrayList<>(); 
//		Relation relation = new Relation(1L,111L);
//		Relation relation0 = new Relation(1L,111L);
//		Relation relation1 = new Relation(1L,111L);
//		Relation relation2 = new Relation(2L,222L);
//		Relation relation3 = new Relation(3L,333L);
//		Relation relation4 = new Relation(4L,444L);
//		Relation relation5 = new Relation(5L,555L);
//		Relation relation6 = new Relation(6L,666L);
//		relations.add(relation);
//		relations.add(relation0);
//		relations.add(relation1);
//		relations.add(relation2);
//		relations.add(relation3);
//		relations.add(relation4);
//		relations.add(relation5);
//		relations.add(relation6);
//		
////		Map<Long,Long> contentMap = relations.stream().collect(Collectors.toMap(Relation::getBbbId,(p)->p.getAaaId()));
////		System.out.println(contentMap.get(111L));
//		
//		
//		
//		
//		relations = relations.stream().collect(collectingAndThen(toCollection(() -> new TreeSet<>(Comparator.comparing(Relation::getAaaId))), ArrayList::new));
//
//		System.out.println(relations.size()); 
		
//		List<Long> a =  splitIdListByStr("");
		List<Relation> lll = new ArrayList<>();
		lll.add(new Relation(23L));
		lll.add(new Relation(33L));
		lll.add(new Relation(43L));
		for(Relation relation : lll){
			System.out.println(relation.toString());
		}
		lll.forEach(relation->{
			relation.setBbbId(888L);
		});
		for(Relation relation : lll){
			System.out.println(relation.toString());
		}
		 
	}

}
