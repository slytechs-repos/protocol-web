/*
 * Sly Technologies Free License
 * 
 * Copyright 2023 Sly Technologies Inc.
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
package com.slytechs.sdk.protocol.web.html;

import java.nio.charset.StandardCharsets;

import com.slytechs.sdk.common.text.DataEmitter;
import com.slytechs.sdk.protocol.core.header.FixedHeader;
import com.slytechs.sdk.protocol.core.id.ProtocolIds;

import static java.lang.foreign.ValueLayout.*;

/**
 * Hypertext Markup Language (HTML).
 *
 */
public final class Html extends FixedHeader {

	/** Html header ID. */
	public static final int ID = ProtocolIds.HTML;
	
	// @formatter:off
	private static final DataEmitter<Html> HTML_EMITTER;
	static {
		HTML_EMITTER = new DataEmitter<>();

		HTML_EMITTER.section("Hypertext Markup Language ({html.len} bytes)", sec -> sec
				.field("Length", h -> h.headerLength(), "html.len"));
	}
	// @formatter:on
	/**
	 * Instantiates a new html.
	 */
	public Html() {
		super(ID, JAVA_BYTE);
	}

	/**
	 * The contents of the html.
	 *
	 * @return the char[]
	 */
	public char[] text() {
		byte[] array = new byte[(int) headerMinLength()];

		return new String(array, StandardCharsets.UTF_8)
				.toCharArray();
	}

	/**
	 * @see com.slytechs.sdk.common.text.Textual#dataEmitter()
	 */
	@Override
	public DataEmitter<?> dataEmitter() {
		return HTML_EMITTER;
	}

}
