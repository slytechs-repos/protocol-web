/*
 * Sly Technologies Free License
 * 
 * Copyright 2025 Sly Technologies Inc.
 *
 * Licensed under the Sly Technologies Free License (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.slytechs.com/free-license-text
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.slytechs.sdk.protocol.web.impl;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import com.slytechs.sdk.protocol.core.Header;
import com.slytechs.sdk.protocol.core.Protocol;
import com.slytechs.sdk.protocol.core.pack.AbstractProtocolPack;
import com.slytechs.sdk.protocol.core.pack.ProtocolPack;

/**
 * @author Mark Bednarczyk [mark@slytechs.com]
 * @author Sly Technologies Inc.
 */
public class WebProtocolPack extends AbstractProtocolPack {

	private static final AtomicReference<WebProtocolPack> SINGLETON = new AtomicReference<>();

	public static final int ID = ProtocolPack.WEB_ID;
	public static final String NAME = "web";
	public static final String DESCRIPTION = "Web family protocol pack";

	public static WebProtocolPack get() {
		if (SINGLETON.get() == null)
			SINGLETON.compareAndSet(null, new WebProtocolPack());

		return SINGLETON.get();
	}

	/**
	 * @param id
	 * @param name
	 * @param description
	 */
	private WebProtocolPack() {
		super(ID, NAME, DESCRIPTION);

		loaded.set(true);
	}

	/**
	 * @see com.slytechs.jnet.proto.api.pack.ProtocolPack#listProtocols()
	 */
	@Override
	public List<Protocol> listProtocols() {
		throw new UnsupportedOperationException("not implemented yet");
	}

	/**
	 * @see com.slytechs.jnet.proto.api.pack.ProtocolPack#mapProtocolUsingId(int)
	 */
	@Override
	public Protocol mapProtocolUsingId(int protocolId) {
		throw new UnsupportedOperationException("not implemented yet");
	}

	/**
	 * @see com.slytechs.jnet.proto.api.pack.ProtocolPack#findProtocol(java.lang.Class)
	 */
	@Override
	public Optional<Protocol> findProtocol(Class<? extends Header> headerClass) {
		throw new UnsupportedOperationException("not implemented yet");
	}

}
