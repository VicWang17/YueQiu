package com.vicwang17.yueqiu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vicwang17.yueqiu.model.domain.Tag;
import com.vicwang17.yueqiu.service.TagService;
import com.vicwang17.yueqiu.mapper.TagMapper;
import org.springframework.stereotype.Service;

/**
* @author vic
* @description 针对表【tag(标签)】的数据库操作Service实现
* @createDate 2024-06-17 20:56:23
*/
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag>
    implements TagService{

}




