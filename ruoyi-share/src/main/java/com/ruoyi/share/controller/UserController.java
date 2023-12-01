package com.ruoyi.share.controller;

import java.util.List;
import java.util.Arrays;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.share.domain.User;
import com.ruoyi.share.service.IUserService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 分享Controller
 *
 * @author ruoyi
 * @date 2023-11-14
 */
@Api(tags="分享管理")
@RestController
@RequestMapping("/share/user")
public class UserController extends BaseController
{
    @Autowired
    private IUserService userService;

    /**
     * 查询分享列表
     */
    @ApiOperation("查询分享列表")
    @PreAuthorize("@ss.hasPermi('share:user:list')")
    @GetMapping("/list")
    public TableDataInfo list(User user)
    {
        startPage();
        List<User> list = userService.selectUserList(user);
        return getDataTable(list);
    }

    /**
     * 导出分享列表
     */
    @ApiOperation("导出分享列表")
    @PreAuthorize("@ss.hasPermi('share:user:export')")
    @Log(title = "分享", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, User user)
    {
        List<User> list = userService.selectUserList(user);
        ExcelUtil<User> util = new ExcelUtil<User>(User.class);
        util.exportExcel(response, list, "分享数据");
    }

    /**
     * 获取分享详细信息
     */
    @ApiOperation("获取分享详细信息")
    @PreAuthorize("@ss.hasPermi('share:user:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(userService.getById(id));
    }

    /**
     * 新增分享
     */
    @ApiOperation("新增分享")
    @PreAuthorize("@ss.hasPermi('share:user:add')")
    @Log(title = "分享", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody User user)
    {
        return toAjax(userService.save(user));
    }

    /**
     * 修改分享
     */
    @ApiOperation("修改分享")
    @PreAuthorize("@ss.hasPermi('share:user:edit')")
    @Log(title = "分享", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody User user)
    {
        return toAjax(userService.updateById(user));
    }

    /**
     * 删除分享
     */
    @ApiOperation("删除分享")
    @PreAuthorize("@ss.hasPermi('share:user:remove')")
    @Log(title = "分享", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(userService.removeByIds(Arrays.asList(ids)));
    }
}
