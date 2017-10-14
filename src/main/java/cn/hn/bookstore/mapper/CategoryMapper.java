package cn.hn.bookstore.mapper;

import cn.hn.bookstore.po.Category;

import java.util.List;

public interface CategoryMapper {

    List<Category> queryAllCategories();

    int deleteByPrimaryKey(String id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}