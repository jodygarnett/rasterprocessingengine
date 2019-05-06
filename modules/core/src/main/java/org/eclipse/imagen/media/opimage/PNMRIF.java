/*
 * Copyright (c) 2019, Oracle and/or its affiliates. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.eclipse.imagen.media.opimage;
import java.io.InputStream;
import java.awt.RenderingHints;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.ParameterBlock;
import java.awt.image.renderable.RenderedImageFactory;
import org.eclipse.imagen.NullOpImage;
import org.eclipse.imagen.OpImage;
import org.eclipse.imagen.media.codec.ImageCodec;
import org.eclipse.imagen.media.codec.ImageDecoder;
import org.eclipse.imagen.media.codec.SeekableStream;

/**
 * A <code>RIF</code> supporting the "PNM" operation in the
 * rendered image layer.
 *
 * @since EA2
 * @see org.eclipse.imagen.operator.PNMDescriptor
 */
public class PNMRIF implements RenderedImageFactory {

    /** Constructor. */
    public PNMRIF() {}

    /**
     * Creates a <code>RenderedImage</code> representing the contents
     * of a PNM-encoded image.
     *
     * @param paramBlock A <code>ParameterBlock</code> containing the PNM
     *        <code>SeekableStream</code> to read.
     * @param renderHints An instance of <code>RenderingHints</code>,
     *        or null.
     */
    public RenderedImage create(ParameterBlock paramBlock,
                                RenderingHints renderHints) {
        return CodecRIFUtil.create("pnm", paramBlock, renderHints);
    }
}
