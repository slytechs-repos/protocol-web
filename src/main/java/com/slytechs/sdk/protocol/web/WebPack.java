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
package com.slytechs.sdk.protocol.web;

import java.util.Collections;
import java.util.List;

import com.slytechs.sdk.protocol.core.id.ProtocolId;
import com.slytechs.sdk.protocol.core.pack.PackId;
import com.slytechs.sdk.protocol.core.pack.ProtocolPack;

/**
 * 
 *
 * @author Mark Bednarczyk [mark@slytechs.com]
 * @author Sly Technologies Inc.
 */
public class WebPack implements ProtocolPack {
	private static final WebPack INSTANCE = new WebPack();

	public static final PackId ID = PackId.WEB;
	public static final String NAME = "Web";
	public static final String DESCRIPTION = "Web protocol pack";
	private final List<ProtocolId> protocols = Collections.unmodifiableList(List.of(Web.values()));
	private boolean isEnabled;

	public static WebPack of() {
		return INSTANCE;
	}

	private WebPack() {}

	/**
	 * @see com.slytechs.sdk.protocol.core.pack.ProtocolPack#packId()
	 */
	@Override
	public PackId packId() {
		return ID;
	}

	/**
	 * @see com.slytechs.sdk.protocol.core.pack.ProtocolPack#name()
	 */
	@Override
	public String name() {
		return NAME;
	}

	/**
	 * @see com.slytechs.sdk.protocol.core.pack.ProtocolPack#description()
	 */
	@Override
	public String description() {
		return DESCRIPTION;
	}

	/**
	 * @see com.slytechs.sdk.protocol.core.pack.ProtocolPack#isEnabled()
	 */
	@Override
	public synchronized boolean isEnabled() {
		return isEnabled;
	}

	/**
	 * @see com.slytechs.sdk.protocol.core.pack.ProtocolPack#setEnabled(boolean)
	 */
	@Override
	public synchronized void setEnabled(boolean enabled) {
		this.isEnabled = enabled;
	}

	/**
	 * @see com.slytechs.sdk.protocol.core.pack.ProtocolPack#protocols()
	 */
	@Override
	public List<? extends ProtocolId> protocols() {
		return protocols;
	}

}
