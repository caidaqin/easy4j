package cn.easy4j.admin.core.db;

import cn.easy4j.admin.modular.entity.SysUserMenu;
import cn.easy4j.framework.db.BaseDbInitializer;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * 用户与权限关联表初始化脚本
 *
 * @author yangzongmin
 * @since 2019-07-19
 */
@Component
public class SysUserMenuInitializer extends BaseDbInitializer {

    @Override
    protected String getTableInitSql() {
        return "CREATE TABLE `sys_user_menu` (" +
                "  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT," +
                "  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP," +
                "  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP," +
                "  `user_id` bigint(20) NOT NULL COMMENT '用户ID，关联sys_user.id'," +
                "  `menu_id` bigint(20) NOT NULL COMMENT '权限ID，关联sys_menu.id'," +
                "  PRIMARY KEY (`id`)," +
                "  KEY `idx_user_id` (`user_id`)" +
                ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户与权限关联表';";
    }

    @Override
    protected List<String> getDataInitSql() {
        return Collections.emptyList();
    }

    @Override
    protected String getTableName() {
        return "sys_user_menu";
    }

    @Override
    protected Class<?> getEntityClass() {
        return SysUserMenu.class;
    }

}
