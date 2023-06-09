DESCRIPTION = "Qt6 development host addon packages"
LICENSE = "MIT"

# disable sanity check for allarch packagegroup
PACKAGE_ARCH = ""

inherit packagegroup nativesdk

PACKAGEGROUP_DISABLE_COMPLEMENTARY = "1"

RDEPENDS:${PN} += " \
    nativesdk-qtapplicationmanager-dev \
    nativesdk-qtapplicationmanager-tools \
    ${@bb.utils.contains('BBFILE_COLLECTIONS', 'openembedded-layer', 'nativesdk-qtgrpc-dev', '', d)} \
    ${@bb.utils.contains('BBFILE_COLLECTIONS', 'openembedded-layer', 'nativesdk-qtgrpc-tools', '', d)} \
    nativesdk-qtquick3d-dev \
    nativesdk-qtquick3d-tools \
    nativesdk-qtremoteobjects-dev \
    nativesdk-qtremoteobjects-tools \
    nativesdk-qtscxml-dev \
    nativesdk-qtscxml-tools \
    nativesdk-qtshadertools-dev \
    nativesdk-qtshadertools-tools \
    nativesdk-qtwayland-dev \
    nativesdk-qtwayland-tools \
    ${FORLINUXHOST} \
"

FORLINUXHOST:mingw32 = ""
FORLINUXHOST = " \
    ${@bb.utils.contains('BBFILE_COLLECTIONS', 'meta-python', 'nativesdk-qtinterfaceframework-dev nativesdk-qtinterfaceframework-tools', '', d)} \
"

