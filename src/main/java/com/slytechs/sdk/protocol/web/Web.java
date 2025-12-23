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

import static com.slytechs.sdk.protocol.core.pack.ProtocolPack.*;

import java.util.List;

import com.slytechs.sdk.protocol.core.Header;
import com.slytechs.sdk.protocol.core.HeaderExtension;
import com.slytechs.sdk.protocol.core.HeaderFactory;
import com.slytechs.sdk.protocol.core.Protocol;
import com.slytechs.sdk.protocol.core.pack.ProtocolPack;
import com.slytechs.sdk.protocol.web.html.Html;
import com.slytechs.sdk.protocol.web.http.Http;
import com.slytechs.sdk.protocol.web.impl.WebProtocolPack;

/**
 * @author Mark Bednarczyk [mark@slytechs.com]
 * @author Sly Technologies Inc.
 */
public enum Web implements Protocol {
	HTTP(Http.class, Constants.HTTP_ID),
	HTML(Html.class, Constants.HTML_ID),
	;

	public interface Constants {
		int HTTP_ID = WEB_ID | 1;
		int HTML_ID = WEB_ID | 2;
	}

	private final int id;

	public static Web valueOf(int id) {
		for (var c : values())
			if (c.id == id)
				return c;

		return null;
	}

	<T extends Header> Web(Class<T> headerClass, int id) {
		this.id = id;
	}

	/**
	 * @see com.slytechs.jnet.proto.api.Protocol#descriptorId()
	 */
	@Override
	public int id() {
		return id;
	}

	/**
	 * @see com.slytechs.jnet.proto.api.Protocol#headerFactory()
	 */
	@Override
	public HeaderFactory<?> headerFactory() {
		throw new UnsupportedOperationException("not implemented yet");
	}

	/**
	 * @see com.slytechs.jnet.proto.api.Protocol#listOptions()
	 */
	@Override
	public List<HeaderExtension> listOptions() {
		throw new UnsupportedOperationException("not implemented yet");
	}

	/**
	 * @see com.slytechs.sdk.protocol.core.Protocol#pack()
	 */
	@Override
	public ProtocolPack pack() {
		return WebProtocolPack.get();
	}

}
