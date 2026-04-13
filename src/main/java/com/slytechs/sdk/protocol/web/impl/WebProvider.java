/*
 * Copyright 2005-2026 Sly Technologies Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.slytechs.sdk.protocol.web.impl;

import com.slytechs.sdk.protocol.core.Protocol;
import com.slytechs.sdk.protocol.core.pack.ProtocolPack;
import com.slytechs.sdk.protocol.core.spi.PackProvider;
import com.slytechs.sdk.protocol.web.Web;
import com.slytechs.sdk.protocol.web.WebPack;
import com.slytechs.sdk.protocol.web.html.HtmlProtocol;
import com.slytechs.sdk.protocol.web.http.HttpProtocol;

/**
 * 
 *
 * @author Mark Bednarczyk [mark@slytechs.com]
 * @author Sly Technologies Inc.
 */
public class WebProvider implements PackProvider {

	/**
	 * @see com.slytechs.sdk.protocol.core.spi.PackProvider#protocolPack()
	 */
	@Override
	public ProtocolPack protocolPack() {
		return WebPack.of();
	}

	/**
	 * @see com.slytechs.sdk.protocol.core.spi.PackProvider#findProtocol(int)
	 */
	@Override
	public Protocol findProtocol(int protocolId) {
		Web id = Web.valueOf(protocolId);
		if (id == null)
			return null;

		return switch (id) {
		case HTTP -> HttpProtocol.of();
		case HTML -> HtmlProtocol.of();
		};
	}

}
