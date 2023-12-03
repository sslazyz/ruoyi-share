package com.ruoyi.share.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.ruoyi.common.utils.StringUtils;
import java.util.List;
import java.util.Map;
import com.ruoyi.share.mapper.ShareMapper;
import com.ruoyi.share.domain.Share;
import com.ruoyi.share.service.IShareService;

/**
 * 分享Service业务层处理
 *
 * @author ruoyi
 * @date 2023-11-14
 */
@Service
public class ShareServiceImpl extends ServiceImpl<ShareMapper, Share> implements IShareService {

    @Autowired
    private ShareMapper shareMapper;

    /**
     * 查询分享列表
     *
     * @param share 分享
     * @return 分享
     */
    @Override
    public List<Share> selectShareList(Share share)
    {
        List<Share> shareList = shareMapper.selectList(buildQueryWrapper(share));
        return shareList;
    }

    @Override
    public List<Share> selectShareUser(Share share)
    {
        List<Share> shareList = shareMapper.selectList(buildQueryWrapper(share));

        return shareList;
    }


    private LambdaQueryWrapper<Share> buildQueryWrapper(Share query) {
        Map<String, Object> params = query.getParams();
        LambdaQueryWrapper<Share> lqw = Wrappers.lambdaQuery();
        lqw.eq(query.getUserId() != null, Share::getUserId, query.getUserId());
        lqw.eq(StringUtils.isNotBlank(query.getTitle()), Share::getTitle, query.getTitle());
        lqw.orderByDesc(Share::getCreateTime);
        lqw.eq(query.getIsOriginal() != null, Share::getIsOriginal, query.getIsOriginal());
        lqw.eq(StringUtils.isNotBlank(query.getAuthor()), Share::getAuthor, query.getAuthor());
        lqw.eq(StringUtils.isNotBlank(query.getCover()), Share::getCover, query.getCover());
        lqw.eq(StringUtils.isNotBlank(query.getSummary()), Share::getSummary, query.getSummary());
        lqw.eq(query.getPrice() != null, Share::getPrice, query.getPrice());
        lqw.eq(StringUtils.isNotBlank(query.getDownloadUrl()), Share::getDownloadUrl, query.getDownloadUrl());
        lqw.eq(query.getBuyCount() != null, Share::getBuyCount, query.getBuyCount());
        lqw.eq(query.getShowFlag() != null, Share::getShowFlag, query.getShowFlag());
        lqw.eq(StringUtils.isNotBlank(query.getAuditStatus()), Share::getAuditStatus, query.getAuditStatus());
        lqw.eq(StringUtils.isNotBlank(query.getReason()), Share::getReason, query.getReason());
        return lqw;
    }

}
