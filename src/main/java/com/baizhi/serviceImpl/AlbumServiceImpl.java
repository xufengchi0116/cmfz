package com.baizhi.serviceImpl;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumDao albumDao;

    @Override
    public Map<String, Object> selectAllAlbum(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<>();
        Album album = new Album();
        RowBounds rowBounds = new RowBounds((page - 1) * rows, rows);
        List<Album> albums = albumDao.selectByRowBounds(album, rowBounds);
        int count = albumDao.selectCount(album);
        map.put("page", page);
        map.put("rows", albums);
        map.put("total", count % rows == 0 ? count / rows : count / rows + 1);
        map.put("records", count);
        return map;
    }

    @Override
    public String add(Album album) {
        String id = UUID.randomUUID().toString();
        album.setId(id);
        album.setCount(0);
        album.setCreateDate(new Date());
        int i = albumDao.insertSelective(album);
        if (i == 0) {
            throw new RuntimeException("专辑添加失败");
        }
        return id;
    }

    @Override
    public void edit(Album album) {
        int i = albumDao.updateByPrimaryKeySelective(album);
        if (i == 0) {
            throw new RuntimeException("修改添加失败");
        }
    }
}
