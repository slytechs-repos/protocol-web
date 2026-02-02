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
package com.slytechs.sdk.protocol.web.http;

import com.slytechs.sdk.protocol.core.Protocol;
import com.slytechs.sdk.protocol.core.header.HeaderFactory;
import com.slytechs.sdk.protocol.core.id.ProtocolIds;
import com.slytechs.sdk.protocol.core.pack.ProtocolPack;
import com.slytechs.sdk.protocol.web.WebPack;

/**
 * 
 *
 * @author Mark Bednarczyk [mark@slytechs.com]
 * @author Sly Technologies Inc.
 */
public final class HttpProtocol implements Protocol {

	private static final HttpProtocol INSTANCE = new HttpProtocol();
	public static final int ID = ProtocolIds.HTTP;
	public static final String NAME = "HTTP";
	public static final ProtocolPack PACK = WebPack.of();
	public static final HeaderFactory<Http> FACTORY = Http::new;

	public static HttpProtocol of() {
		return INSTANCE;
	}

	private HttpProtocol() {}

	/**
	 * @see com.slytechs.sdk.protocol.core.Protocol#id()
	 */
	@Override
	public int id() {
		return ID;
	}

	/**
	 * @see com.slytechs.sdk.protocol.core.Protocol#name()
	 */
	@Override
	public String name() {
		return NAME;
	}

	/**
	 * @see com.slytechs.sdk.protocol.core.Protocol#protocolPack()
	 */
	@Override
	public ProtocolPack protocolPack() {
		return PACK;
	}

	/**
	 * @see com.slytechs.sdk.protocol.core.Protocol#headerFactory()
	 */
	@Override
	public HeaderFactory<?> headerFactory() {
		return FACTORY;
	}

}
