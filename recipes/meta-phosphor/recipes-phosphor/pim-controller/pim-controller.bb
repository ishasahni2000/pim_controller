SUMMARY = "PIM Controller DBus app"
LICENSE = "Apache-2.0"

inherit meson pkgconfig

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4b6a97989a2308ce8d5e1b2628df56cd"

# Use your Git repo or local folder
SRC_URI = "git://github.com/ishasahni2000/pim_controller.git;branch=main;protocol=https"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

DEPENDS += "sdbusplus"

SYSTEMD_SERVICE:${PN} = "pim-controller.service"

inherit meson pkgconfig systemd

EXTRA_OEMESON += "-Dcpp_args=-std=c++20"

do_install:append() {
    install -Dm755 ${B}/picservice ${D}${bindir}/picservice
    install -Dm644 ${S}/pim-controller.service ${D}${systemd_system_unitdir}/pim-controller.service
}

FILES:${PN} += "${systemd_system_unitdir}/pim-controller.service"

