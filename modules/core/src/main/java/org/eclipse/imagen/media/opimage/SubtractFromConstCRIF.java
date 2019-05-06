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
import java.awt.RenderingHints;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.ParameterBlock;
import org.eclipse.imagen.CRIFImpl;
import org.eclipse.imagen.ImageLayout;
import java.util.Map;

/**
 * A <code>CRIF</code> supporting the "SubtractFromConst" operation in
 * the rendered and renderable image layers.
 *
 * @see org.eclipse.imagen.operator.SubtractFromConstDescriptor
 * @see SubtractFromConstOpImage
 *
 *
 * @since EA2
 */
public class SubtractFromConstCRIF extends CRIFImpl {

    /** Constructor. */
    public SubtractFromConstCRIF() {
        super("subtractfromconst");
    }

    /**
     * Creates a new instance of <code>SubtractFromConstOpImage</code>
     * in the rendered layer.
     *
     * @param args   The source image and the constants.
     * @param hints  Optionally contains destination image layout.
     */
    public RenderedImage create(ParameterBlock args,
                                RenderingHints renderHints) {
        // Get ImageLayout from renderHints if any.
        ImageLayout layout = RIFUtil.getImageLayoutHint(renderHints);
        

        return new SubtractFromConstOpImage(args.getRenderedSource(0),
                                            renderHints,
                                            layout,
                                         (double[])args.getObjectParameter(0));
    }
}
