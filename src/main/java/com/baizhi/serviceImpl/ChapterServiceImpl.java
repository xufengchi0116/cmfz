package com.baizhi.serviceImpl;

import com.baizhi.dao.ChapterDao;
import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private ChapterDao chapterDao;

    @Override
    public Map<String, Object> selectChaptersByAlbumId(String albumId, Integer page, Integer rows) {
        HashMap<String, Object> map = new HashMap<>();
        Chapter chapter = new Chapter();
        chapter.setAlbumId(albumId);
        RowBounds rowBounds = new RowBounds((page - 1) * rows, rows);
        List<Chapter> chapters = chapterDao.selectByRowBounds(chapter, rowBounds);
        int count = chapterDao.selectCount(chapter);
        map.put("page", page);
        map.put("rows", chapters);
        map.put("total", count % rows == 0 ? count / rows : count / rows + 1);
        map.put("records", count);
        return map;
    }

    @Override
    public String add(Chapter chapter) {
        String id = UUID.randomUUID().toString();
        chapter.setId(id);
        chapter.setCreateDate(new Date());
        int i = chapterDao.insertSelective(chapter);
        if (i == 0) {
            throw new RuntimeException("添加章节失败");
        }
        return id;
    }

    @Override
    public void edit(Chapter chapter) {
        chapterDao.updateByPrimaryKeySelective(chapter);
    }
}
