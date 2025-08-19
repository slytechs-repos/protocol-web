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
package com.slytechs.jnet.protocol.web.html;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.nio.charset.StandardCharsets;

import com.slytechs.jnet.protocol.api.Header;
import com.slytechs.jnet.protocol.web.Web;

import static java.lang.foreign.ValueLayout.*;

/**
 * Hypertext Markup Language (HTML).
 *
 */
public final class Html extends Header {

	/** Html header ID. */
	public static final int ID = Web.Constants.HTML_ID;

	/**
	 * Instantiates a new html.
	 */
	public Html() {
		super(ID, JAVA_BYTE);
	}

	public Html(Arena arena) {
		super(ID, JAVA_BYTE, arena);
	}

	public Html(MemorySegment pointer) {
		super(ID, JAVA_BYTE, pointer);
	}

	public Html(MemorySegment seg, long offset) {
		super(ID, JAVA_BYTE, seg, offset);
	}

	/**
	 * The contents of the html.
	 *
	 * @return the char[]
	 */
	public char[] text() {
		byte[] array = new byte[headerLength()];

		return new String(array, StandardCharsets.UTF_8)
				.toCharArray();
	}

}
