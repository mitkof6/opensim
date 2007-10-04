function numberOfChildren = nodeNumberOfChildren( node )
% Returns number of child nodes of this node, generated by the parseXML
% method.
numberOfChildren = length( node.Children );
