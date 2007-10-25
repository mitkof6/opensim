function values = findAndGetValuesFromTags( fileNode, desiredTagNames, values )

numberOfChildrenInMainBody = fileNode.getChildNodes.getLength;
for i = 0:numberOfChildrenInMainBody-1
    currentNode = fileNode.getChildNodes.item(i);
    if currentNode.hasChildNodes
        currentTagName = char( currentNode.getTagName );
        anyDesiredTagNamesThatMatchCurrentTag = strcmpi( desiredTagNames, currentTagName );
        indicesOfCurrentTagInDesiredTagNames = find( anyDesiredTagNamesThatMatchCurrentTag );
        if ~isempty( indicesOfCurrentTagInDesiredTagNames )
            if length( indicesOfCurrentTagInDesiredTagNames ) > 1
                error( ['Repeated occurrences of tag ' currentTagName ' in desiredTagNames.'] );
            end
            indexOfCurrentTagInDesiredTagNames = indicesOfCurrentTagInDesiredTagNames(1);
            values{ indexOfCurrentTagInDesiredTagNames } = currentNode.getChildNodes.item(0).getData;
        end
    end
end