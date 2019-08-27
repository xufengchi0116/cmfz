package com.baizhi.serviceImpl;

import com.baizhi.dao.BannerDao;
import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerDao bannerDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Map<String, Object> selectAllBanner(Integer page, Integer rows) {

        Integer begin = (page - 1) * rows;
        List<Banner> list = bannerDao.selectAllBanner(begin, rows);

        Integer count = bannerDao.count();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("page", page);       //当前页码数值
        map.put("rows", list);    //当前页中的banner数据
        map.put("total", count % rows == 0 ? count / rows : count / rows + 1); //总页数
        map.put("records", count);   //总条数

        return map;
    }

    @Override
    public String add(Banner banner) {

        String id = UUID.randomUUID().toString();
        banner.setId(id);
        banner.setCreate_date(new Date());
        if ("".equals(banner.getCover())) {
            banner.setCover(null);
        }
        bannerDao.add(banner);

        return id;
    }

    //添加图片
    @Override
    public void update(Banner banner) {
        bannerDao.update(banner);
    }

    @Override
    public void edit(Banner banner) {
        banner.setCreate_date(new Date());
        bannerDao.edit(banner);
    }

    @Override
    public void del(Banner banner) {

        bannerDao.del(banner.getId());

    }
}
