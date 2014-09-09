require go.inc

inherit cross

deltask configure

do_compile() {
  export GOBIN="${D}${bindir}"
  export GOROOT_FINAL="${D}${libdir}/go"

  export GOHOSTOS="linux"
  export GOOS="linux"

  ## TODO: make these conditional
  export GOARCH="arm"
  export GOARM="7"
  export GOHOSTARCH="amd64"

  export CGO_ENABLED="1"
  ## TODO: consider setting GO_EXTLINK_ENABLED

  export CC="${BUILD_CC}"
  export CC_FOR_TARGET="${TARGET_SYS}-gcc"
  export CXX_FOR_TARGET="${TARGET_SYS}-g++"
  export GO_CCFLAGS="${HOST_CFLAGS}"
  export GO_LDFLAGS="${HOST_LDFLAGS}"

  ./make.bash
}

do_install() {
  ## TODO:
  #- it turns out that `${D}${bindir}` is already populated
  #- we need to copy the rest, unfortunatelly pretty much everything
  #  (see http://sources.gentoo.org/cgi-bin/viewvc.cgi/gentoo-x86/dev-lang/go/go-1.3.1.ebuild?view=markup)
}
