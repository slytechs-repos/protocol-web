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
package com.slytechs.sdk.protocol.web;

import com.slytechs.sdk.protocol.core.id.ProtocolId;
import com.slytechs.sdk.protocol.core.id.ProtocolIds;

/**
 * @author Mark Bednarczyk [mark@slytechs.com]
 * @author Sly Technologies Inc.
 */
public enum Web implements ProtocolId {
	HTTP(ProtocolIds.HTTP),
	HTML(ProtocolIds.HTML),
	;

	private final int id;

	public static Web valueOf(int id) {
		for (var c : values())
			if (c.id == id)
				return c;

		return null;
	}

	Web(int id) {
		this.id = id;
	}

	/**
	 * @see com.slytechs.jnet.proto.api.Protocol#id()
	 */
	@Override
	public int id() {
		return id;
	}

}
