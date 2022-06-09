package twilightforest.entity.projectile;

import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import twilightforest.init.TFEntities;
import twilightforest.entity.monster.Troll;
import twilightforest.util.TFDamageSources;

import javax.annotation.Nullable;

public class ThrownBlock extends TFThrowable {

	private BlockState state = Blocks.STONE.defaultBlockState();

	public ThrownBlock(EntityType<? extends TFThrowable> type, Level worldIn) {
		super(type, worldIn);
	}

	public ThrownBlock(Level world, LivingEntity thrower, @Nullable BlockState state) {
		super(TFEntities.THROWN_BLOCK.get(), world, thrower);
		if(state != null) {
			this.state = state;
		}
	}

	@Override
	protected void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		tag.put("BlockState", NbtUtils.writeBlockState(this.state));
	}

	@Override
	protected void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
		this.state = NbtUtils.readBlockState(tag.getCompound("BlockState"));
	}

	@Override
	public void handleEntityEvent(byte id) {
		if (id == 3) {
			ParticleOptions particle = new BlockParticleOption(ParticleTypes.BLOCK, state);
			for (int i = 0; i < 20; i++) {
				this.level.addParticle(particle, false, this.getX(), this.getY(), this.getZ(), random.nextGaussian() * 0.05D, random.nextDouble() * 0.2D, random.nextGaussian() * 0.05D);
			}
		} else {
			super.handleEntityEvent(id);
		}
	}

	@Override
	protected void onHitEntity(EntityHitResult result) {
		super.onHitEntity(result);
		if(result.getEntity() instanceof LivingEntity living && !(living instanceof Troll) && !this.level.isClientSide) {
			living.hurt(TFDamageSources.THROWN_BLOCK, 6);

			this.level.broadcastEntityEvent(this, (byte) 3);
			this.discard();
		}
	}

	@Override
	protected void onHitBlock(BlockHitResult result) {
		super.onHitBlock(result);
		if (!this.level.isClientSide) {
			this.level.broadcastEntityEvent(this, (byte) 3);
			this.discard();
		}
	}

	public BlockState getBlockState() {
		return state;
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return new ClientboundAddEntityPacket(this, Block.getId(this.getBlockState()));
	}

	@Override
	public void recreateFromPacket(ClientboundAddEntityPacket packet) {
		super.recreateFromPacket(packet);
		this.state = Block.stateById(packet.getData());
	}
}
