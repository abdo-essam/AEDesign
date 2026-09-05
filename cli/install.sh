#!/bin/bash
set -e

# Build the Shadow JAR
echo "Building AEDesign CLI Shadow JAR..."
./gradlew :cli:shadowJar

# Target directory for the binary
INSTALL_DIR="/usr/local/bin"
JAR_SOURCE="cli/build/libs/aedesign.jar"
JAR_TARGET="/usr/local/share/aedesign/aedesign.jar"

echo "Installing jar file to /usr/local/share/aedesign/..."
sudo mkdir -p /usr/local/share/aedesign
sudo cp "$JAR_SOURCE" "$JAR_TARGET"

echo "Creating launcher script in $INSTALL_DIR/aedesign..."
sudo tee "$INSTALL_DIR/aedesign" > /dev/null << 'EOF'
#!/bin/bash
java -jar /usr/local/share/aedesign/aedesign.jar "$@"
EOF

sudo chmod +x "$INSTALL_DIR/aedesign"

echo ""
echo "AEDesign CLI installed successfully! Try running:"
echo "  aedesign --help"
echo ""
