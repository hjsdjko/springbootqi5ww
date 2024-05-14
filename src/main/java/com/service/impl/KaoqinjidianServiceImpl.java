package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.KaoqinjidianDao;
import com.entity.KaoqinjidianEntity;
import com.service.KaoqinjidianService;
import com.entity.vo.KaoqinjidianVO;
import com.entity.view.KaoqinjidianView;

@Service("kaoqinjidianService")
public class KaoqinjidianServiceImpl extends ServiceImpl<KaoqinjidianDao, KaoqinjidianEntity> implements KaoqinjidianService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KaoqinjidianEntity> page = this.selectPage(
                new Query<KaoqinjidianEntity>(params).getPage(),
                new EntityWrapper<KaoqinjidianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KaoqinjidianEntity> wrapper) {
		  Page<KaoqinjidianView> page =new Query<KaoqinjidianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<KaoqinjidianVO> selectListVO(Wrapper<KaoqinjidianEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KaoqinjidianVO selectVO(Wrapper<KaoqinjidianEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KaoqinjidianView> selectListView(Wrapper<KaoqinjidianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KaoqinjidianView selectView(Wrapper<KaoqinjidianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
