/**
 * 
 */
package com.test.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 10007610
 *
 */
public class TestMapCollections {

	/**
	 * 
	 */
	public TestMapCollections() {
		// TODO Auto-generated constructor stub
	}
	
	public class RecommendCacheDTO{
		private Long id;
		
		private String name;
		
		private String code;
		
		private Long categoryId;
		
		public RecommendCacheDTO(){}
		
		

		public RecommendCacheDTO(Long id, String name, String code,
				Long categoryId) {
			super();
			this.id = id;
			this.name = name;
			this.code = code;
			this.categoryId = categoryId;
		}



		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public Long getCategoryId() {
			return categoryId;
		}

		public void setCategoryId(Long categoryId) {
			this.categoryId = categoryId;
		}
		
	}
	
	public List<RecommendCacheDTO> makeRecommendCacheDTOs(){
		List<RecommendCacheDTO> list = new ArrayList<>();
		RecommendCacheDTO recommendCacheDTO1 = new RecommendCacheDTO(1L,"����","zhangsan",22L);
		RecommendCacheDTO recommendCacheDTO2 = new RecommendCacheDTO(2L,"����","lisi",22L);
		RecommendCacheDTO recommendCacheDTO3 = new RecommendCacheDTO(3L,"����","wangwu",22L);
		RecommendCacheDTO recommendCacheDTO4 = new RecommendCacheDTO(4L,"����","zhaoliu",24L);
		RecommendCacheDTO recommendCacheDTO5 = new RecommendCacheDTO(5L,"����","wuqi",24L);
		RecommendCacheDTO recommendCacheDTO6 = new RecommendCacheDTO(6L,"��Զ�","ddd",24L);
		RecommendCacheDTO recommendCacheDTO7 = new RecommendCacheDTO(7L,"������","fff",24L);
		RecommendCacheDTO recommendCacheDTO8 = new RecommendCacheDTO(8L,"������","rrr",26L);
		list.add(recommendCacheDTO1);
		list.add(recommendCacheDTO2);
		list.add(recommendCacheDTO3);
		list.add(recommendCacheDTO4);
		list.add(recommendCacheDTO5);
		list.add(recommendCacheDTO6);
		list.add(recommendCacheDTO7);
		list.add(recommendCacheDTO8);
		return list;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		TestMapCollections testMapCollections = new TestMapCollections();
		
		List<RecommendCacheDTO> recommendCacheDTOs = testMapCollections.makeRecommendCacheDTOs();
		
		
        Map<Long,List<RecommendCacheDTO>> categoryRecommendMap = new HashMap<Long,List<RecommendCacheDTO>>();
        recommendCacheDTOs.forEach(recommendCacheDTO -> {
            Long key = recommendCacheDTO.getCategoryId();
            if(categoryRecommendMap.get(key)==null){
                categoryRecommendMap.put(key,new ArrayList<RecommendCacheDTO>());
            }
            categoryRecommendMap.get(key).add(recommendCacheDTO);
        });  //��
        
//        recommendCacheDTOs.forEach(recommendCacheDTO -> {
//            Long key = recommendCacheDTO.getCategoryId();
//            List<RecommendCacheDTO> recommendCacheDTOList = categoryRecommendMap.get(key)==null?new ArrayList<>():categoryRecommendMap.get(key);
//            recommendCacheDTOList.add(recommendCacheDTO);
//            categoryRecommendMap.put(key,recommendCacheDTOList);
//        });  //��
        
//        for(RecommendCacheDTO recommendCacheDTO  : recommendCacheDTOs){
//          Long key = recommendCacheDTO.getCategoryId();
//          if(categoryRecommendMap.get(key)==null){
//              categoryRecommendMap.put(key,new ArrayList<RecommendCacheDTO>());
//          }
//          categoryRecommendMap.get(key).add(recommendCacheDTO);
//        }//��
        
//        for(RecommendCacheDTO recommendCacheDTO  : recommendCacheDTOs){
//          Long key = recommendCacheDTO.getCategoryId();
//          List<RecommendCacheDTO> recommendCacheDTOList = categoryRecommendMap.get(key)==null?new ArrayList<>():categoryRecommendMap.get(key);
//          recommendCacheDTOList.add(recommendCacheDTO);
//          categoryRecommendMap.put(key,recommendCacheDTOList);
//        }//��
        
        
        List<RecommendCacheDTO> recommendCacheDTOs1  = (List<RecommendCacheDTO>) categoryRecommendMap.get(22L);
        List<RecommendCacheDTO> recommendCacheDTOs2  = (List<RecommendCacheDTO>) categoryRecommendMap.get(24L);
        System.out.println(recommendCacheDTOs1.size());

	}

}
