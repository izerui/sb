package com.sb.hyh.shiro;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class ShiroRealmImpl extends AuthorizingRealm {

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken usernamePasswordToke = (UsernamePasswordToken) token;
		String username = usernamePasswordToke.getUsername();
		String encodedPassword = new Sha256Hash(usernamePasswordToke.getPassword()).toBase64();

		// 校验权限
		System.out.println("username: " + username);
		System.out.println("password: " + encodedPassword);
		System.out.println("principal: " + usernamePasswordToke.getPrincipal());

		return new SimpleAuthenticationInfo(new ShiroUser("用户id", "用户编码", "用户名称"),
				String.valueOf(usernamePasswordToke.getPassword()), ByteSource.Util.bytes("用户id"), getName());
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("由于加入了缓存,此处只会load一次：doGetAuthorizationInfo");

		// 得到 doGetAuthenticationInfo 方法中传入的凭证
		ShiroUser shiroUser = (ShiroUser) principals.fromRealm(getName()).iterator().next();
		String userName = shiroUser.getName();
		if (StringUtils.equals("admin", userName)) {
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			info.addRole("admin");
			info.addStringPermission("user:edit");
			return info;
		} else if (StringUtils.equals("test", userName)) {
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			info.addRole("test");
			info.addStringPermission("user:view");
			return info;
		} else {
			return null;
		}
	}
}
