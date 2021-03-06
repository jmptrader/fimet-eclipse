package com.fimet.editor.usecase;

import org.eclipse.core.filebuffers.IDocumentSetupParticipant;
import org.eclipse.jface.text.DefaultPositionUpdater;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IPositionUpdater;

/**
 * Registers a position updater that tracks changes for the {@link JsonTextEditor#JSON_CATEGORY} positions.
 * This class is managed through an extension point.
 */
public class DocumentSetup implements IDocumentSetupParticipant {

    private final IPositionUpdater updater = new DefaultPositionUpdater(UseCaseEditor.USE_CASE_CATEGORY);

    @Override
    public void setup(IDocument document) {
    	//System.out.println("DocumentSetup.setup(IDocument document) " + document.getClass().getName());
        document.addPositionCategory(UseCaseEditor.USE_CASE_CATEGORY);
        document.addPositionUpdater(updater);
    }

}
