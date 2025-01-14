/*
 * Copyright 2002-2024 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.security.authorization.method;

import org.aopalliance.intercept.MethodInvocation;

import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.security.authorization.AuthorizationResult;

/**
 * An implementation of {@link MethodAuthorizationDeniedHandler} that throws
 * {@link AuthorizationDeniedException}
 *
 * @author Marcus da Coregio
 * @since 6.3
 */
public final class ThrowingMethodAuthorizationDeniedHandler implements MethodAuthorizationDeniedHandler {

	@Override
	public Object handle(MethodInvocation methodInvocation, AuthorizationResult result) {
		throw new AuthorizationDeniedException("Access Denied", result);
	}

	@Override
	public Object handle(MethodInvocation methodInvocation, AuthorizationDeniedException authorizationDenied) {
		throw authorizationDenied;
	}

}
